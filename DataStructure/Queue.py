# Queue implements First In First Out (FIFO)
class Queue:
    __items: list

    def __init__(self):
        self.__items = []

    def is_empty(self):
        return self.__items == []

    def add(self, element)->bool:
        self.__items.append(element)
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
    queue = Queue()
    print(queue.is_empty())
    queue.add('abay')
    queue.add(['baya'])
    queue.add(21)
    print(queue.is_empty())
    print(queue.size())
    print(queue.peek())
    print(queue.remove())
    print(queue.to_array())
