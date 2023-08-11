is_Member(K, [K|_]).

is_Member(K, [_|Tail]) :-
  is_Member(K, Tail).

students_In_Course(Course,Student):-
    students_In_Course([],Course,Student).

students_In_Course(TmpList,Course,Student):-
    student(Id,Course,Grade),
    not(is_Member([Id,Grade],TmpList)),!,
    append([[Id,Grade]],TmpList,NewTmpList),
    students_In_Course(NewTmpList,Course,Student).

students_In_Course(Student,_,Student).

listSize([],0).

listSize([_|T],Num):-
  listSize(T,Num1),
  Num is Num1+1.

num_Students(Course,Num):-
  students_In_Course(Course,Student),
  listSize(Student,Num).

get_Student_Grades(Id,Grades):-
  get_Student_Grades([],Id,Grades).

get_Student_Grades(TmpList,Id,Grades):-
  student(Id,_,Grade),
  not(is_Member(Grade,TmpList)),!,
  append([Grade],TmpList,NewTmpList),
  get_Student_Grades(NewTmpList,Id,Grades).

max(X,Y,X):- X>=Y,!.
max(X,Y,Y):- Y>=X,!.

maxOfList([X],X).

maxOfList([X,Y|T],Max):-
  maxOfList([Y|T],MaxOfTail),
  max(X,MaxOfTail,Max).

max_Student_Grade(Id,MaxGrade):-
  get_Student_Grades(Id,Grades),
  maxOfList(Grades,MaxGrade),!.

max_l([X],X) :- !, true.
max_l([X|Xs], Mx):-
       max_l(Xs, Mx), Mx >= X ,!.
max_l([X|Xs], X):-
       max_l(Xs, Mx), X >  Mx.


students_Grade(X,List):-
    students_Grade(X,[],List).


students_Grade(Number,XList,List):-
    student(Number,_,Y),
    not(member([Y],XList)),!,
    append([[Y]],XList,NewList),
    students_Grade(Number,NewList,List).

students_Grade(_,List,List).

max_Student_Grade(X, MaxGrade):-
    students_Grade(X, List),
    max_l(List , MaxGrade).
