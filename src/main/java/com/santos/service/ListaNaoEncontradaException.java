package com.santos.service;

public class ListaNaoEncontradaException extends RuntimeException {
	  private static final long serialVersionUID = 1L;

	  ListaNaoEncontradaException(Long id) {
        super("Lista " + id + " não encontrada");
      }
}