#include<iostream.h>
#include<conio.h>
struct process
{
    int no;
    int at,et,wt,tt;
    int tet;
    int t;
};
 
void main()
{
    process p[99];
    int i,j,k;
    cout<<"\n Enter No of Processes:";
    int np;
    cin>>np;
 
    for (i=0;i<np;i++)
    {
        cout<<"\n Enter Execution time of process"<<i+1<<":";
        cin>>p[i].et;
        p[i].tet=p[i].et;
        p[i].at=p[i].t=p[i].tt=p[i].wt=0;
        p[i].no=i+1;
    }
 
    cout<<"\n Enter Time Quantum:";
    int q;
    cin>>q;
 
    cout<<"\n Entered Data";
    cout<<"\n Process\tET";
    for(i=0;i<np;i++)
    {
        cout<<"\n "<<p[i].no<<"\t"<<p[i].et;
    }
 
    int totaltime=0;
    for(i=0;i<np;i++)
    {
        totaltime+=p[i].et;
    }
 
    i=0;
    k=0;
 
    int rrg[99];
    for(j=0;j<totaltime;j++)
    {
        if((k==0)&&(p[i].et!=0))
        {
            p[i].wt=j;
            if((p[i].t!=0))
            {
                p[i].wt-=q*p[i].t;
            }
        }
        if((p[i].et!=0)&&(k!=q))
        {
            rrg[j]=p[i].no;
            p[i].et-=1;
            k++;
        }
        else
        {
            if((k==q)&&(p[i].et!=0))
            {
                p[i].t+=1;
            }
            i=i+1;
            if(i==np)
            {
                i=0;
            }
 
                k=0;
            j=j-1;
        }
    }
    int twt=0;
    int ttt=0;
    cout<<"\n Result Of Round Robin";
    cout<<"\n PNo\tET\tWT\tTT";
    for(i=0;i<np;i++)
    {
        p[i].tt=p[i].wt+p[i].tet;
        ttt+=p[i].tt;
        twt+=p[i].wt;
        cout<<"\n "<<p[i].no<<"\t"<<"\t"<<p[i].tet<<"\t"<<p[i].wt<<"\t"<<p[i].tt;
    }
 
    cout<<"\n Average Waiting Time:"<<(float)twt/np;
    cout<<"\n Average Turn Around Time:"<<(float)ttt/np;
 
    getch();
}
 
/* Output
 
 
 Enter No of Processes:5
 
 Enter Execution time of process1:10
 
 Enter Execution time of process2:29
 
 Enter Execution time of process3:3
 
 Enter Execution time of process4:7
 
 Enter Execution time of process5:12
 
 Enter Time Quantum:10
 
 Entered Data
 Process        ET
 1      10
 2      29
 3      3
 4      7
 5      12
 Result Of Round Robin
 PNo    ET      WT      TT
 1              10      0       10
 2              29      32      61
 3              3       20      23
 4              7       23      30
 5              12      40      52
 Average Waiting Time:23
 Average Turn Around Time:35.2
 
*/
