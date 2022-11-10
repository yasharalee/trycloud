
Feature: uset should have access to contact list

  @contact_list @all
Scenario Outline: verify users can see all the contact names on the contact list
  Given When the users log in with valid "<username>" and "<password>"
  When the user clicks the right side "Contacts" module
  Then verify the contact names are in the list


  Examples:
    | username | password    |
    | User17   | Userpass123 |
    | User47   | Userpass123 |
    | User77   | Userpass123 |
    | User107  | Userpass123 |