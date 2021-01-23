def insertion_sort(array: list)->list:
    for processed_index in range(1, len(array)):
        new_index = processed_index - 1
        while new_index >= 0 and array[new_index+1] < array[new_index]:
            array[new_index], array[new_index+1] = array[new_index+1], array[new_index]
            new_index = new_index - 1
    return array


if __name__ == '__main__':
    array_test = [9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3]
    sorted_array = insertion_sort(array_test)
    print(sorted_array)
