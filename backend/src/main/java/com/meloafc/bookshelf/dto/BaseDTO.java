package com.meloafc.bookshelf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseDTO implements Serializable {
}
