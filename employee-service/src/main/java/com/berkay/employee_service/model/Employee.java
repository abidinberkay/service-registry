package com.berkay.employee_service.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
