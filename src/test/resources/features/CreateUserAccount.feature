Feature: 6thStreet.com - Create User Account Scenarios 

@Smoke
Scenario Outline: Create user account with email_id and Password
	When User clicks on login link 
	Then Create account "<FirstName>""<LastName>""<EMAIL>" and "<Password>"
	
	Examples: 
		|FirstName|LastName| EMAIL                |Password                   |
		|	uat_automation_tester	|	2	|	uat_automation_tester2@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	3	|	uat_automation_tester3@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	4	|	uat_automation_tester4@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	5	|	uat_automation_tester5@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	6	|	uat_automation_tester6@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	7	|	uat_automation_tester7@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	8	|	uat_automation_tester8@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	9	|	uat_automation_tester9@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	10	|	uat_automation_tester10@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	11	|	uat_automation_tester11@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	12	|	uat_automation_tester12@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	13	|	uat_automation_tester13@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	14	|	uat_automation_tester14@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	15	|	uat_automation_tester15@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	16	|	uat_automation_tester16@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	17	|	uat_automation_tester17@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	18	|	uat_automation_tester18@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	19	|	uat_automation_tester19@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	20	|	uat_automation_tester20@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	21	|	uat_automation_tester21@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	22	|	uat_automation_tester22@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	23	|	uat_automation_tester23@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	24	|	uat_automation_tester24@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	25	|	uat_automation_tester25@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	26	|	uat_automation_tester26@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	27	|	uat_automation_tester27@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	28	|	uat_automation_tester28@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	29	|	uat_automation_tester29@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	30	|	uat_automation_tester30@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	31	|	uat_automation_tester31@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	32	|	uat_automation_tester32@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	33	|	uat_automation_tester33@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	34	|	uat_automation_tester34@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	35	|	uat_automation_tester35@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	36	|	uat_automation_tester36@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	37	|	uat_automation_tester37@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	38	|	uat_automation_tester38@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	39	|	uat_automation_tester39@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	40	|	uat_automation_tester40@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	41	|	uat_automation_tester41@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	42	|	uat_automation_tester42@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	43	|	uat_automation_tester43@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	44	|	uat_automation_tester44@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	45	|	uat_automation_tester45@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	46	|	uat_automation_tester46@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	47	|	uat_automation_tester47@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	48	|	uat_automation_tester48@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	49	|	uat_automation_tester49@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	50	|	uat_automation_tester50@yopmail.com	|	6Thstreet!	|
		|	uat_automation_tester	|	51	|	uat_automation_tester51@yopmail.com	|	6Thstreet!	|