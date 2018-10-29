import java.util.*;
class fcfs_dsk
{
public static void main(String args[])
{
int n,i,hs,flag,total=0;
Scanner sc=new Scanner(System.in);
System.out.println(“Enter no of cylinders”);
n=sc.nextInt();
int c[]=new int[n];
int hm[]=new int[n];
System.out.println(“Enter the cylinder no.”);
for(i=0;i<n;i++)
c[i]=sc.nextInt();
System.out.println(“enter head start”);
hs=sc.nextInt();
flag=hs;
for(i=0;i<n;i++)
{
if(c[i] > flag)
hm[i]=c[i]-flag;
else
hm[i]=flag-c[i];
flag=c[i];
}
for(i=0;i<n;i++)
total=total+hm[i];
System.out.println(“The total no of cylinders traversed during disk movement is:”+ total);
}
}
