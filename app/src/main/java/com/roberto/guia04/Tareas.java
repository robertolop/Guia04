package com.roberto.guia04;

import androidx.annotation.NonNull;

public class Tareas {

 // Declaración de variables
 String titulo;
 String descripcion;
 String fecha;
 String hora;

 // Constructor de la clase
 public Tareas() {
  this.titulo = titulo;
  this.descripcion = descripcion;
  this.fecha = fecha;
  this.hora = hora;
 }

 // Métodos Getters y Setters
 public String getTitulo() {
  return titulo;
 }

 public void setTitulo(String titulo) {
  this.titulo = titulo;
 }

 public String getDescripcion() {
  return descripcion;
 }

 public void setDescripcion(String descripcion) {
  this.descripcion = descripcion;
 }

 public String getFecha() {
  return fecha;
 }

 public void setFecha(String fecha) {
  this.fecha = fecha;
 }

 public String getHora() {
  return hora;
 }

 public void setHora(String hora) {
  this.hora = hora;
 }

 @NonNull
 @Override
 public String toString() {
  return super.toString();
 }
}