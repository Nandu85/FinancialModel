package com.narola.financialcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultDAO {

	List<Result> list = null;

	static MoreValues values = null;

	FinancialInfo info = null;

    @Autowired
    DBConnection dbConnection;

	public List<Result> getResults(FinancialInfo financialInfo) {
		list = new ArrayList<>();

		info = financialInfo;

        info = AddFinanancialInfo(info);

		int retirementYear = financialInfo.getRetireMentYear();
		Result result1 = new Result();
		result1.setCurrentYear(financialInfo.getCurrentYear());
		result1.setIncome(financialInfo.getIncome());
		if(result1.getCurrentYear()==retirementYear)
			result1.setIncome(0);

		result1.setExpense(financialInfo.getExpense());
		double balance = financialInfo.getFixedAmount() + financialInfo.getIncome() - financialInfo.getExpense();
		result1.setBalance(round(balance));
		result1.setInvestment5(round(balance * 0.2));
		result1.setInvestment8(round(balance * 0.3));
		result1.setInvestment15(round(balance * 0.5));
		double roi = result1.getInvestment5() * 0.05 + result1.getInvestment8() * 0.08
				+ result1.getInvestment15() * 0.15;
		result1.setRoi(round(roi));
		result1.setTotalBalance(round(balance + roi));

		list.add(result1);

		for (int i = 1; i <= financialInfo.getNoOfYears(); i++) {
			Result result2 = new Result();
			result2.setCurrentYear(result1.getCurrentYear() + 1);
			result2.setIncome(round(result1.getIncome() * (1 + info.getiGrowthRate()/100)));
			if(result1.getCurrentYear()>=retirementYear)
				result1.setIncome(0);
			result2.setExpense(round(result1.getExpense() * (1 + info.geteGrowthRate()/100)));
			balance = result1.getTotalBalance() + result2.getIncome() - result2.getExpense();
			result2.setBalance(round(balance));
			result2.setInvestment5(round(balance * 0.2));
			result2.setInvestment8(round(balance * 0.3));
			result2.setInvestment15(round(balance * 0.5));
			roi = result2.getInvestment5() * 0.05 + result2.getInvestment8() * 0.08 + result2.getInvestment15() * 0.15;
			result2.setRoi(round(roi));
			result2.setTotalBalance(round(balance + roi));

			list.add(result2);

			result1 = result2;
		}

		return list;
	}

	public List<Result> getResults() {
		return list;
	}

	public MoreValues getOtherValues(FinancialInfo info) {
		double sum = 0;
		int i = list.size();
		double total = list.get(i - 1).getTotalBalance();
		while (i > 0) {
			sum = sum + list.get(i - 1).getExpense();
			i--;
		}
		values = new MoreValues(info.getIncome() * 0.7, info.getIncome() * 1.5, round(total - sum));
		return values;
	}

	public MoreValues getOtherValues() {

		return getOtherValues(info);
	}

	public static double round(double d) {
		if (d > 0)
			return (double) (Math.floor(d * 100)) / 100;
		else {
			return (double) (Math.ceil(d * 100)) / 100;
		}
	}

    public FinancialInfo AddFinanancialInfo(FinancialInfo info) {
        Connection con = dbConnection.getConnection();

        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement("INSERT INTO `finnancialinfo`\n" +
                            "(`fixedAmount`,`income`,\n" +
                            "`expense`,`incomeGrowthRate`,\n" +
                            "`expenseGrowthRate`,`noOfYears`,\n" +
                            "`currentYear`,`retirementYear`)\n" +
                            "VALUES (?,?,?,?,?,?,?,?);\n",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, info.getFixedAmount());
            ps.setDouble(2, info.getIncome());
            ps.setDouble(3, info.getExpense());
            ps.setDouble(4, info.getiGrowthRate());

            ps.setDouble(5, info.geteGrowthRate());
            ps.setDouble(6, info.getNoOfYears());
            ps.setDouble(7, info.getCurrentYear());
            ps.setDouble(8, info.getRetireMentYear());

            ps.executeUpdate();
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {

                info.setInfoId(resultSet.getInt(1));


            }
        } catch (SQLException e) {
            throw new DatabaseException("Error while insert cart", e);
        } catch (DatabaseException e) {
            throw e;
        } finally {
            DBConnection.releaseResource(ps, resultSet);
        }
        return info;
    }

}
