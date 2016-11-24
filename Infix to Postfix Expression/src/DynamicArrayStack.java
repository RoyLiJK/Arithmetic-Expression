public class DynamicArrayStack<AnyType> implements Stack<AnyType>
{
  public static final int DEFAULT_CAPACITY = 256;
  AnyType[] data;
  int topOfStack;

  public DynamicArrayStack() { this(DEFAULT_CAPACITY); }

  public DynamicArrayStack(int capacity)
  {
    topOfStack = -1;
    data = (AnyType[]) new Object[capacity];
  }

  public int size()
  {  
    return  topOfStack+1;
  }

  public boolean isEmpty()
  {
    if(topOfStack >= 0)
    {
    	return false;
    }
    return true;
  }

  public void push(AnyType newValue)
  {
	  if(topOfStack == DEFAULT_CAPACITY)
	  {
		  resize(size() * 2);
	  }
	 data[++topOfStack] = newValue;  
  }

  public AnyType top()
  {
	  if(this.isEmpty())
	  {
		  return null;
	  }
	  else
	  {
		  return (AnyType) data[topOfStack];
	  }
  }

  public AnyType pop()
  {
	  if(topOfStack == size() *.25)
	  {
		  resize(size() / 2);
	  }
	  
	  if(isEmpty())
	  { 
		  return null;
	  }
	  else
	  {		  
		  return data[topOfStack--];
		 
	  }	  
  }

  protected void resize(int newCapacity)
  {
    int n = size();

    AnyType[] temp = (AnyType[]) new Object[newCapacity];
    for (int i=0; i < n; i++)
      temp[i] = data[i];
    data = temp;
  }
}

/*  in the pop method, if the number of values in the stack is ¼ the
amount of current storage in the stack then shrink the amount of storage in the stack to ½ of its current size.
You cannot use the built in version of this data structure in the Java Collections Framework.*/


