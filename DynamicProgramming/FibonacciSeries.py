def fibonacci(index: int):
    if index == 1:
        return [1]
    elif index == 2:
        return [1, 1]
    elif index > 2:
        result = [1, 1]
        result_index = 2
        while result_index != (index-1):
            result.append(result[result_index-2] + result[result_index-1])
            result_index = result_index + 1
        return result
    else:
        return []


def recursive_fibonacci_implementation(index, two_step_before=None, one_step_before=None, last_sequence=None):
    new_value = two_step_before + one_step_before
    last_sequence.append(new_value)
    if len(last_sequence) < index:
        return recursive_fibonacci_implementation(index, one_step_before, new_value, last_sequence)
    else:
        return last_sequence


def recursive_fibonacci(index):
    if index == 1:
        return [1]
    elif index == 2:
        return [1, 1]
    elif index > 2:
        return recursive_fibonacci_implementation(index, 1, 1, [1, 1])


if __name__ == '__main__':
    sequence = recursive_fibonacci(100)
    print(sequence)
