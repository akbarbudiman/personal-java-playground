# Stack implements Last In First Out (LIFO)
class Stack:
    __items: list

    def __init__(self):
        self.__items = []

    def is_empty(self):
        return self.__items == []

    def add(self, element)->bool:
        self.__items.insert(0, element)
        return True

    def remove(self):
        return self.__items.pop(0) if len(self.__items) > 0 else None

    def peek(self):
        return self.__items[0]

    def to_array(self):
        return self.__items

    def size(self):
        return len(self.__items)


if __name__ == '__main__':
    stack = Stack()
    print(stack.is_empty())
    stack.add('abay')
    stack.add(['baya'])
    stack.add(21)
    print(stack.is_empty())
    print(stack.size())
    print(stack.peek())
    print(stack.remove())
    print(stack.to_array())
