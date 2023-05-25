package in.suraj.binding;

import javax.validation.constraints.NotBlank;

import lombok.Data;

public class UnlockForm {

	@NotBlank(message = "This field should not be empty")
	private String tempPassword;

	@NotBlank(message = "This field should not be empty")
	private String newPassword;

	@NotBlank(message = "This field should not be empty")
	private String confirmPassword;

	private String email;

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
