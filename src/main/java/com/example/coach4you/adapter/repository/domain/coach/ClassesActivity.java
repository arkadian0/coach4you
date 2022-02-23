package com.example.coach4you.adapter.repository.domain.coach;

import com.example.coach4you.adapter.repository.domain.coach.enums.ClassesActivityType;

public class ClassesActivity {

  private ClassesActivityType classesActivityType;

  public ClassesActivity(
      ClassesActivityType classesActivityType) {
    this.classesActivityType = classesActivityType;
  }

  public ClassesActivityType getClassesActivityType() {
    return classesActivityType;
  }

}
