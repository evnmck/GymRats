INSERT INTO user (FName, LName, Username, Password, Bio) VALUES ('Evan', 'McKnight', 'evnmck', 
'PassWord123', 'What am I doing');
INSERT INTO user (FName, LName, Username, Password, Bio) VALUES ('Ximena', 'Canahui', 'ximenacc', 
'PassWord0816', 'Go Hokies');
INSERT INTO user (FName, LName, Username, Password, Bio) VALUES ('Pranav', 'Patel', 'pranavp', 
'Passwordwordstrong', 'Just here for the vibes');
INSERT INTO user (FName, LName, Username, Password, Bio) VALUES ('Cuong', 'Ngo', 'ngoct', 
'123password', 'Working out is my passion. Let’s lift together sometime!');
INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('Juan', 'Carlos', 
'jcarlos', 'PassWord1234', 'I love running', 1);
INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('Daniel', 'Megill', 
'dmegill', 'PassWord12345', 'I hate running', 1);
INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('Daniel', 'Getu', 
'dgetu', 'PassWord3826', 'I LoVe RunNiNG', 2);
INSERT INTO user (FName, LName, Username, Password, Bio, FK_Trainer_Id) VALUES ('Charlyn', 
'Castillo', 'ccastillo', 'PassWord4604', 'What’s running?', 3);
INSERT INTO user (FName, LName, Username, Password, FK_Trainer_Id) VALUES ('Miley', 
'Cyrus','countrygirl26', 'appleS@uce!', 4);
INSERT INTO user (FName, LName, Username, Password) VALUES ('Harry', 'Styles', 'harrystyles', 
'oned!r3ction4ever');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Shrey', 'Kalra', 'shreky', 
'passworrd100omg');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Dev', 'Rambhad', 'devr45', 
'123password');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Askhay', 'Akula', 'akshaya', 
'Mypasswordisamazing');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Lebron', 'James', 'king23', 
'betterthenjordan');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Dwayne', 'Johnson', 'therock', 
'password123@#');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Billie', 'Eilish', 'itsbillie', 
'jellyB3@ns123');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Sally', 'Hamouda', 'sallyh' , 
'123password');
INSERT INTO user (FName, LName, Username, Password) VALUES ('John', 'Smith', 'jsmith', 
'123password');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Tim', 'Sands', 'tsands', 
'123password');
INSERT INTO user (FName, LName, Username, Password) VALUES ('Bob', 'Bob', 'bob', '123password');
INSERT INTO Exercise (Exercise_Name) VALUES ('squat');
INSERT INTO Exercise (Exercise_Name) VALUES ('deadlift');
INSERT INTO Exercise (Exercise_Name) VALUES ('pushup');
INSERT INTO Exercise (Exercise_Name) VALUES ('hip abductor');
INSERT INTO Exercise (Exercise_Name) VALUES ('arm curl');
INSERT INTO Exercise (Exercise_Name) VALUES ('facepulls'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('pullups'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('chinups'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('calf raises'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('leg press');
INSERT INTO Exercise (Exercise_Name) VALUES ('Hamstring curl');
INSERT INTO Exercise (Exercise_Name) VALUES ('Bench');
INSERT INTO Exercise (Exercise_Name) VALUES ('Lateral Raises'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('Leg Extension');
INSERT INTO Exercise (Exercise_Name) VALUES ('Dips');
INSERT INTO Exercise (Exercise_Name) VALUES ('Run');
INSERT INTO Exercise (Exercise_Name) VALUES ('Jog');
INSERT INTO Exercise (Exercise_Name) VALUES ('Walk'); 
INSERT INTO Exercise (Exercise_Name) VALUES ('Skull Crusher');
INSERT INTO Exercise (Exercise_Name) VALUES ('Curlups');
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (10,1,1,15,30,7,3,20,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (3,2,1,70,95,10,4,25,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (13,3,1,45,65,8,3,20,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (14,3,2,60,80,8,4,25,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (17,2,2,100,130,6,3,18,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (8,1,1,15,30,7,3,20,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (8,2,1,70,95,10,4,25,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (8,3,1,45,65,8,3,20,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (9,3,2,60,80,8,4,25,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (9,2,2,100,130,6,3,18,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,2,5,20,25,10,3,90,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,3,5,200,225,10,4,90,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,5,5,22,25,11,3,190,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (4,2,5,135,145,10,5,100,(curdate())); 
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (4,8,5,15,15,12,3,110,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,1,1,15,15,12,3,110,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,2,1,15,15,12,3,110,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,3,1,15,15,12,3,110,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,4,1,15,15,12,3,110,(curdate()));
INSERT INTO workout (Workout_Id, FK_Exercise_Id, FK_User_Id, Start_Weight, End_Weight, 
Repetitions, Sets, Time_in_Minutes, Date) VALUES (1,5,1,15,15,12,3,110,(curdate()));
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (1, (curdate()), 50, 12, 90, 60, 34, 90, 100);
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (2, (curdate()), 12, 45, 32, 78, 34, 12, 11); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (3, (curdate()), 11, 10, 9, 8, 7, 6, 5); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (4, (curdate()), 2, 3, 5, 8, 13, 21, 34); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (5, (curdate()), 100, 111, 112, 113, 113, 114, 56);
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (16, (curdate()), 24.3, 22.40, 24.70, 20.10, 10.6, 130, 64); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (17, (curdate()), 28.3, 26.1, 25.8, 23, 13.1, 155, 70); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (18, (curdate()), 26.3, 24, 25.8, 25.6, 15.10, 160, 72); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (19, (curdate()), 24.3, 22.1, 25.8, 24.9, 11.2, 145, 68); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (20, (curdate()), 26.1, 24.7, 27.3, 22.4, 13.7, 150, 64);
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (11, (curdate()), 30, 30, 28, 110 , 13, 100, 65); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (12, (curdate()), 50, 20, 78, 113 , 130, 100, 65); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (13, (curdate()), 40, 20, 48, 80 , 120, 100, 60); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (14, (curdate()), 33, 20, 23, 180 , 190, 100, 74); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (15, (curdate()), 20, 30, 28, 110 , 143, 100, 64);
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (6, (curdate()), 30, 30, 28, 110 , 13, 100, 65); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (7, (curdate()), 50, 20, 78, 113 , 130, 100, 65); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (8, (curdate()), 40, 20, 48, 80 , 120, 100, 60); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight, 
Height) VALUES (9, (curdate()), 33, 20, 23, 180 , 190, 100, 74); 
INSERT INTO body_progress (FK_User_Id, Date_Measured, Chest, Waist, Hips, Thigh, Biceps, Weight,
Height) VALUES (10, (curdate()), 20, 30, 28, 110 , 143, 100, 64);
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (1,1,'Stop skipping 
legs'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (1,2,'Text me'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (1,3,'Good progress!');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (2,4,'More reps on 
squats please'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,5,'Add overhead 
press');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (2,6,'Im like that'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,7,'Built Different'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (4,8,'Work Harder!'); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (4,9,'You suck '); 
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (2,10,'Talk to me 
nice');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (1,11,'Great 
workout!');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,12,'You kicked 
butt!');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (4,13,'Take me on a 
run next time!! ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,14,'You just beat my 
PR! ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (2,15,'You inspire me! 
');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (1,16,'Nice! ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,17,'Lmao ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (4,18,'You go it! ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (3,19,'Try again ');
INSERT INTO comments (FK_Commenter_Id, FK_Workout_Id, Comment) VALUES (2,20,'Litty');