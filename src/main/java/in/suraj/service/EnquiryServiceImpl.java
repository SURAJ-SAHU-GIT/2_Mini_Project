package in.suraj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.suraj.binding.DashBoardResponse;
import in.suraj.binding.EnquiryForm;
import in.suraj.binding.EnquirySearchCriteria;
import in.suraj.entity.StudentEnqEntity;
import in.suraj.entity.UserDtlsEntity;
import in.suraj.repo.CourseRepo;
import in.suraj.repo.EnqStatusRepo;
import in.suraj.repo.StudentEnqRepo;
import in.suraj.repo.UserDtlsRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private StudentEnqRepo studentRepo;

	@Autowired
	private UserDtlsRepo userRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private EnqStatusRepo statusRepo;

	@Override
	public Boolean saveEnquiry(EnquiryForm form, Integer userId) {

		Optional<UserDtlsEntity> findById = userRepo.findById(userId);
		UserDtlsEntity user = findById.get();

		if (form.geteId() != null) {
			
			StudentEnqEntity entity = studentRepo.findById(form.geteId()).get();
			entity.setClassMode(form.getClassMode());
			entity.setCourseName(form.getCourseName());
			entity.setEnquiryStatus(form.getEnquiryStatus());
			entity.setPhno(form.getPhno());
			entity.setStudentName(form.getStudentName());
			entity.setUser(user);
			
			entity.setUser(user);

			studentRepo.save(entity);

			return true;
		}

		StudentEnqEntity entity = new StudentEnqEntity();

		BeanUtils.copyProperties(form, entity);

		entity.setUser(user);

		studentRepo.save(entity);

		return true;
	}

	@Override
	public List<StudentEnqEntity> getEnquiries(Integer userId, EnquirySearchCriteria search) {

		StudentEnqEntity entity = new StudentEnqEntity();

		Optional<UserDtlsEntity> findById = userRepo.findById(userId);
		UserDtlsEntity user = findById.get();

		BeanUtils.copyProperties(search, entity);

		entity.setUser(user);

		Example<StudentEnqEntity> example = Example.of(entity);
		List<StudentEnqEntity> list = studentRepo.findAll(example);

		return list;
	}

	@Override
	public DashBoardResponse getDashboardData(Integer userId) {

		Optional<UserDtlsEntity> findById = userRepo.findById(userId);
		UserDtlsEntity user = findById.get();

		List<StudentEnqEntity> enquiries = user.getLstOfEnquiries();
		long enrolledCount = enquiries.stream().filter(e -> e.getEnquiryStatus().equalsIgnoreCase("enrolled")).count();

		long lostCount = enquiries.stream().filter(e -> e.getEnquiryStatus().equalsIgnoreCase("lost")).count();

		long totalCount = enquiries.stream().count();

		DashBoardResponse data = new DashBoardResponse();

		data.setEnrolledEnquiries((int) enrolledCount);
		data.setLostEnquiries((int) lostCount);
		data.setNoOfEnquiries((int) totalCount);

		return data;
	}

	@Override
	public List<String> getCourseNames() {
		List<String> courses = courseRepo.getCourse();
		return courses;
	}

	@Override
	public List<String> getEnquiryStatus() {
		List<String> statusNames = statusRepo.getStatusNames();
		return statusNames;
	}

	@Override
	public StudentEnqEntity getStudentEnq(Integer eId) {
		Optional<StudentEnqEntity> findById = studentRepo.findById(eId);
		StudentEnqEntity entity = findById.get();
		return entity;
	}

}
