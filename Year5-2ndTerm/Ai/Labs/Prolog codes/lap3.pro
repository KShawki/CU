/*Define the predicate member that checks if an element is a member of a list.*/
member(X,[X|T]).
member(X,[H|T]):-
    member(X,T).

/*Consider programming delete/3, such that delete(X, A, B) is true if
X is a member of A and B is the result of removing any one occurrence of X
from A.*/
delete(X, [X], []).
delete(X,[X|T],T).
delete(X,[H|T1],[H|T2]):-
    delete(X,T1,T2).

/*Define the predicate addone/2(L1, L2) with L1 and L2 both lists of
integers such that addone is true if for every element of L1 the corresponding
element in L2 is obtained by adding 1 to the element of L1.*/
addone([],[]).
addone([H|T],[H1,T1]):-
    H1 is H + 1,
    addone(T,T1).

/*return the element before the last element in a list.*/
before_last([X, Y], X).
before_last([H|T], X):-
    before_last(T, X).

/*Define a predicate that finds the sum of a list*/
sum([X],X).
sum([H|T],S):-
    sum(T,S1),
    S is S1+ H.

/*Define  a  predicate  that  finds  the  length  of  a  list*/
length([],0).
length([H|T],R):-
    length(T,R1),
    R is R1+1.


