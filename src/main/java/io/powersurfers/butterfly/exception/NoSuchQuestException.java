package io.powersurfers.butterfly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There is no such quest")
public class NoSuchQuestException extends RuntimeException {
}
