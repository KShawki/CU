/**
 * 1- Describe why the base Ackermann function is so heavy to compute
 *    let fun(m) = A(n, m)
 *      at = 0 ->   fun(m) = m + 1
 *      at = 1 ->   fun(m) = m + 2
 *      at = 2 ->   fun(m) = 2m
 *      at = 3 ->   fun(m) = 2^m
 *      at = 4 ->   fun(m) = ((2)^2))^2 m times
 *
 *      the graph is growth up because the fun(m) is primitive recursive;
 */


/*
#include <iostream>
#include <stack>
using namespace std;

long ackermann(long m, long n);

int main () {
    int m,n; cin >> m >> n;
    cout << ackermann(m,n) << endl;
    return 0;
}

long ackermann(long m, long n) {

    long stack[1000];
    int position = 1;
    stack[0] = m;
    stack[1] = n;

    while (position) {
        n = stack[position--];
        m = stack[position];
    }

}
*/

//Refence: https://www.geeksforgeeks.org/ackermanns-function-using-dynamic-programming/

#include <iostream>
using namespace std;

int ackermann(int m,int n);

int main()
{
    int m,n; cin >> m >> n;
    cout << ackermann(m,n) << endl;
    return 0;
}

int ackermann(int m,int n)
{
    if(m==0)
        return n+1;
    else if((m>0)&&(n==0))
        return ackermann(m-1,1);
    else if((m>0)&&(n>0))
        return ackermann (m-1,ackermann(m,n-1));
}
