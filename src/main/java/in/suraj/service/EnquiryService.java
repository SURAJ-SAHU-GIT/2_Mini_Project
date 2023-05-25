package in.suraj.service;

import java.util.List;

import in.suraj.binding.DashBoardResponse;
import in.suraj.binding.EnquiryForm;
import in.suraj.binding.EnquirySearchCriteria;
import in.suraj.entity.StudentEnqEntity;

public interface EnquiryService {
	
List<String> getCourseNames();
	
	List<String> getEnquiryStatus();
	
	DashBoardResponse getDashboardData(Integer userId);
	
	Boolean saveEnquiry(EnquiryForm form,Integer userId);
	
	List<StudentEnqEntity> getEnquiries(Integer userId,EnquirySearchCriteria search);
	
	StudentEnqEntity getStudentEnq(Integer eId);

}
