
  @accessFile @all
    Feature: As a user, I should be able to access to Files module
      User Story: As a user, I should be able to access to Files module.

      Scenario Outline: verify users can select all the uploaded files from the page
        Given user enters <credential com number> from credentials excel "<sheet>"
        When the user clicks the "Files" module
        And user click the top-left checkbox of the table
        Then verify all the files are selected


        Examples:
          | sheet       | credential com number |
          | credentials | 1                     |
          | credentials | 2                     |
          | credentials | 3                     |
          | credentials | 4                     |