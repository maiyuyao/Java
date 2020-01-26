package com.essence.advanced.annotation.ex03;

@Table("DESADV001")
public class DESADV {

	@Column("MESID")
	private int MESID_1;

	@Column("COMPANY")
	private String COMPANY_2;

	@Column("INVOICE")
	private String INVOICE_3;

	@Column("PO")
	private String PO_4;

	public int getMESID_1() {
		return MESID_1;
	}

	public void setMESID_1(int mESID_1) {
		MESID_1 = mESID_1;
	}

	public String getCOMPANY_2() {
		return COMPANY_2;
	}

	public void setCOMPANY_2(String cOMPANY_2) {
		COMPANY_2 = cOMPANY_2;
	}

	public String getINVOICE_3() {
		return INVOICE_3;
	}

	public void setINVOICE_3(String iNVOICE_3) {
		INVOICE_3 = iNVOICE_3;
	}

	public String getPO_4() {
		return PO_4;
	}

	public void setPO_4(String pO_4) {
		PO_4 = pO_4;
	}
}