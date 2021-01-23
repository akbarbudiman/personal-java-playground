def bubble_sort(array):
    did_swapping = True
    while did_swapping is True:
        did_swapping = False
        for index in range(1, len(array)):
            if array[index] < array[index-1]:
                array[index-1], array[index] = array[index], array[index-1]
                did_swapping = True
    return array


if __name__ == '__main__':
    # array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    # sorted_array = bubble_sort(array_test)
    # print(sorted_array)

    list_int = list(map(int, list_of_number.split(" ")))
    print(len(list_int))
    sorted_list = bubble_sort(list_int)
    print(sorted_list)
    print(sorted_list[int((len(list_int)-1)/2)])
