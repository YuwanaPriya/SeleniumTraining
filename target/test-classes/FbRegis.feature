Feature: To validate the Fb creation of Fb application


Background:
Given To launch the browser and maximise the window

@Regresssion @sanity
Scenario: To create a new account
When To launch url of fb application
And To click the create new account button
And To pass first in first name text box
|selenium|python|java|php|react native|
And To pass in second name in second  name textbox
And To pass mobileno or email in email text box
|priyanka@gmail.com	|904689997			|inmakes@gmail.com	|909887657				|
|8700754609					|priya@gmail.com|679012456					|meena@gmail.com	|
|89006345678				|098765435			|selenium@gmail.com	|9034569900				|
And  To create new password using new password text box
Then To close the chrome browser



@smoke
Scenario: To create a new account
Given To launch the browser and maximise the window
When To launch url of fb application
And To click the create new account button
And To pass first in first name text boxAnd  To create new password using new password text box
Then To close the chrome browser