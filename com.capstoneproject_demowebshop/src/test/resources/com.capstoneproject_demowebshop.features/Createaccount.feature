Feature: Register using mail id
Background:
Given Home page of website
@createaccountwithvalidemail
Scenario Outline: Register on the website with new mail id
When click on regiter
And Choose gender
And Enter "<First name>" in first name field
And Enter "<Second name>" in second name field
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Enter "<Confirm password>" in confirm password field
And click on register button
Then Registered successfuly

Examples:
|First name      |Second name        |Email                        |Password        |Confirm password |
|Yogeshwaran  |Muniyandi            |mncntk@gmail.com        |123456            |123456                 |

@createaccountwithinvalidemail
Scenario Outline: Register on the website with invalid email

And click on regiter
And Choose gender
And Enter "<First name>" in first name field
And Enter "<Second name>" in second name field
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Enter "<Confirm password>" in confirm password field
And click on register button
Then Invalid email

Examples: 
|First name      |Second name        |Email                        |Password        |Confirm password |
|Yogeshwaran  |Muniyandi            |mnc@gmail.com        |123456            |123456                 |

@loginwithvalidcredentials
Scenario Outline: Login with valid credentials
When Click on login
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Click on login button
Then Logged in successfully

Examples:
|Email                                    |Password|
|sit20co010@sairamtap.edu.in|123456   |

@loginwithinvalidcredentials
Scenario Outline: Login with valid credentials

When Click on login
And Enter "<Email>" in email field
And Enter "<Password>" in password field
And Click on login button
Then invalid login credentials

Examples:
|Email                                    |Password|
|warany979@gmail.com         |123456   |

@Forgotpasswordwithvalidemail
Scenario Outline: Forgot password with valid email
When Click on login
And Click on Forgot password
And Enter "<Email>" in email field
And Click on recover button
Then Email sent message displayed

Examples:
|Email                    |
|mnc@gmail.com   |

@Forgotpasswordwithinvalidemail
Scenario Outline: Forgot password with valid email
When Click on login
And Click on Forgot password
And Enter "<Email>" in email field
And Click on recover button
Then Email does not exist  message displayed

Examples:
|Email                    |
|warany979@gmail.com   |
