package com.microservice1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpceptionController {
	@ExceptionHandler(value = NullFeild.class)
    public ResponseEntity<Object> exception(NullFeild exception) {
		return new ResponseEntity<>("Field is null", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = PasswordNotMatch.class)
    public ResponseEntity<Object> exception2(PasswordNotMatch exception) {
		return new ResponseEntity<>("Password  is not match to the confim Password ", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = EmailFormat.class)
    public ResponseEntity<Object> exception3(EmailFormat exception) {
		return new ResponseEntity<>("Email format is not correct ", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = SameCompanyName.class)
    public ResponseEntity<Object> exception4(SameCompanyName exception) {
		return new ResponseEntity<>("Company name is duplicate it must be unique ", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = IdNotFound.class)
    public ResponseEntity<Object> exception5(IdNotFound exception) {
		return new ResponseEntity<>("Id is not Found ", HttpStatus.BAD_REQUEST);
	}

	


}
