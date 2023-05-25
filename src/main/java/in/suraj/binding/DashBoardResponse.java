package in.suraj.binding;


public class DashBoardResponse {

	private int noOfEnquiries;
	private int enrolledEnquiries;
	private int lostEnquiries;
	public int getNoOfEnquiries() {
		return noOfEnquiries;
	}
	public void setNoOfEnquiries(int noOfEnquiries) {
		this.noOfEnquiries = noOfEnquiries;
	}
	public int getEnrolledEnquiries() {
		return enrolledEnquiries;
	}
	public void setEnrolledEnquiries(int enrolledEnquiries) {
		this.enrolledEnquiries = enrolledEnquiries;
	}
	public int getLostEnquiries() {
		return lostEnquiries;
	}
	public void setLostEnquiries(int lostEnquiries) {
		this.lostEnquiries = lostEnquiries;
	}
	

}