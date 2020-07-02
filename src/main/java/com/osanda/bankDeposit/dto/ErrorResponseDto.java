package com.osanda.bankDeposit.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/***
 * 
 * details of the error response mesage
 * 
 * @author Osanda Wedamulla
 *
 */

@Data
@ToString
@NoArgsConstructor
public class ErrorResponseDto implements Serializable {

	private static final long serialVersionUID = 4406139840139509600L;

	private String error;

	private LocalDateTime timeStamp = LocalDateTime.now();

	public ErrorResponseDto(String error) {
		this.error = error;
	}

}// ErrorResponseDto {}
