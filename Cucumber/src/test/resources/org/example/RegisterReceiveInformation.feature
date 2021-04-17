Feature: RegisterReceiveInformation

  /*As an end user I want the ability to provide my information, so that I may receive the
  newsletters from provider

  Acceptance Criteria:

  · The information is: Email, Full Name, Gender, News Type – It is a type of newsletter that users
  want to receive, default value is “Tất cả”. All information is required.

  · User need to provide the Email not in used for registration. After successfully register, the extra
  information is requested.

  · The popup message “Bạn đã đăng ký thành công” will be showed and one confirmation email is sent to
  user after success.

  · The corresponding error message is showed for invalid case.
  */

  Scenario:Check when user input valid email
    Given The home page is displayed
    When User register with email "bichhuevcweb@gmail.com"
    Then the extra information is displayed

   Scenario: Check when user input invalid email
     Given The home page is displayed
     When User register with email "daotao@testmaster.vn"
     Then the popup "E-mail daotao@testmaster.vn đã được sử dụng, bạn hãy chọn một E-mail khác" should be displayed

   Scenario: check when user register with blank value for fullName, gender and newType
     Given The home page is displayed
     When User register with email "bichhuevcweb@gmail.com"
     And user register with blank value for fullName, gender and newType
     Then in-line error message "* Bạn cần phải nhập dữ liệu" should be display

   Scenario: check when user register with valid value for fullName, gender and newType
     Given The home page is displayed
     When User register with email "bichhuevcweb@gmail.com"
     And user register with fullName "hue"
     Then the success popup "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký" should be displayed