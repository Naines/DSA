public class twoNonRepeatedInArray 
{
    static void find(int arr[])
    {
        int xor=0, e1=0, e2=0;

        for(int i: arr)
        xor=xor^i;

        xor=xor&(-xor);

        //results all elements of the set divided in either >0 or =0.
        //one ans has =0
        //other >0.
        //extract furthur by using xor prop of a^a=0.
        for(int i:arr)
        {
            if((xor&i)>0)
            e1=e1^i;
            else 
            e2=e2^i;
        }
        System.out.println(e1+" "+e2);
    }
    public static void main(String[] args) {
        int arr[]={2,2,3,4,4,5,5,6,6,7,8,8};
        //int arr[]={2, 3, 7, 9, 11, 2, 3, 11};
        find(arr);
    }
}
