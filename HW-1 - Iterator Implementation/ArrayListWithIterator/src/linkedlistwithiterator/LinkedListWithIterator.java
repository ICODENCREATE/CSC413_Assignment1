package linkedlistwithiterator;

import java.util.*;

/**s
   A class that implements the ADT list. The list has an iterator. The class extends MyLList.
 */
public class LinkedListWithIterator<T> extends MyLList<T> implements ListWithIteratorInterface<T>
{
	public LinkedListWithIterator()
	{
		super();
	} // end default constructor

	public Iterator<T> getIterator()
	{
		return new IteratorForLinkedList();
	} // end getIterator

	public Iterator<T> iterator()
	{
		return getIterator();
	} // end iterator

	private class IteratorForLinkedList implements Iterator<T>
	{
		private int     nextPosition;  // Position of next entry in the iteration 
		private boolean wasNextCalled; // Needed by remove

		private IteratorForLinkedList()
		{
			nextPosition = 1;
			wasNextCalled = false;
		} // end default constructor

		public boolean hasNext()
		{
			return nextPosition <= getLength();
		} // end hasNext

		public T next()
		{
			if (hasNext())
			{
				wasNextCalled = true;
				T nextEntry = getEntry(nextPosition);
				nextPosition++; // Advance iterator

				return nextEntry;
			} 
			else
				throw new NoSuchElementException("Illegal call to next();" +
						"iterator is after end of list.");
		} 

		public void remove()
		{
			if (wasNextCalled)
			{
				// nextPosition was incremented by the call to next, so it 
				// is 1 more than the position number of the entry to be removed
				nextPosition--;  // Index of next entry in iteration
				LinkedListWithIterator.this.remove(nextPosition);
				wasNextCalled = false;	// Reset flag
			} 
			else
				throw new IllegalStateException("Illegal call to remove(); " +
						"next() was not called.");
		} 	
	}
}
