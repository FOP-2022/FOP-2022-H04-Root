import org.sourcegrade.submitter.submit

plugins {
  id("org.sourcegrade.submitter") version "0.4.0"
}

submit {
  assignmentId = "h04"
  studentId = "ab12cdef"
  firstName = "sol_first"
  lastName = "sol_last"
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}
