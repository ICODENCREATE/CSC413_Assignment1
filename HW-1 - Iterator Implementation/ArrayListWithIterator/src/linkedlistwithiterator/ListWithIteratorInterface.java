package linkedlistwithiterator;

import java.util.Iterator;
/**
   An interface for the ADT list that has an iterator.
*/
public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>
{
   public Iterator<T> getIterator();
}

