
Feature: uset should have access to contact list

  @contact_list @all
Scenario Outline: verify users can see all the contact names on the contact list
    Given user enters <credential com number> from credentials excel "<sheet>"
  When the user clicks the right side "Contacts" module
  Then verify the contact names are in the list


    Examples:
      | sheet       | credential com number |
      | credentials | 1                     |
      | credentials | 2                     |
      | credentials | 3                     |
      | credentials | 4                     |