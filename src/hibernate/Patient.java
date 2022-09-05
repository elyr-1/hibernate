package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// map class to database table
@Entity
@Table(name="clinic_records")

public class Patient {


	// map fields to database columns
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_no")
	private int appointmentNo;
	
	@Column(name="doctor_no")
	private String doctorNo;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="patient_no")
	private String patientNo;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="operation_no")
	private String operationNo;
	
	// constructor
	public Patient() {}
	
	public Patient(String doctorNo, String doctorName, String patientNo, String patientName, String operationNo) {
		this.doctorNo = doctorNo;
		this.doctorName = doctorName;
		this.patientNo = patientNo;
		this.patientName = patientName;
		this.operationNo = operationNo;
	}

	//getters
	public int getAppointmentNo() {
		return appointmentNo;
	}
	
	public String getDoctorNo() {
		return doctorNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getOperationNo() {
		return operationNo;
	}

	// setters
	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setOperationNo(String operationNo) {
		this.operationNo = operationNo;
	}

	@Override
	public String toString() {
		return "doctorNo=" + doctorNo + ", doctorName=" + doctorName + ", patientNo=" + patientNo
				+ ", patientName=" + patientName + ", operationNo=" + operationNo;
	}
	
}
