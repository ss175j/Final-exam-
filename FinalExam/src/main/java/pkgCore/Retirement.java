package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWork;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWork = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}
	public double AmountToSave()
	{
		double dMonthsToWork = iYearsToWork * 12;
		 dAnnualReturnWork = (dAnnualReturnWork / 100) / 12;
		double pmt = FinanceLib.pmt(dAnnualReturnWork, dMonthsToWork, 0, this.TotalAmountSaved(), false);
		pmt = Math.round(pmt * 100.0) / 100.0;
		return pmt;
	}

	
	public double TotalAmountSaved()
	{
		double dMonthsRetired = this.iYearsRetired * 12;
		double rAnnaulReturnRetired =this.dAnnualReturnRetired / 12;
		double dRequiredIncome = this.dRequiredIncome;
		double dMonthlySSI = this.dMonthlySSI;
        double pv = FinanceLib.pv(rAnnaulReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
        return pv;
	}
}
