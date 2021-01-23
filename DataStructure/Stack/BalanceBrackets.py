# reference:
# https://leetcode.com/problems/valid-parentheses/
# https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

class BalanceBrackets:
class BalanceBrackets:


    def is_balance_without_native_stack(self, string: str) -> bool:
        bracket_pair = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        stack = []

        for char in string:
            if char in bracket_pair.values():
                stack.append(char)

            else:
                if len(stack) == 0:
                    return False

                valid_pair = bracket_pair.get(char)
                last_stack = stack.pop()
                if valid_pair != last_stack:
                    return False

        if len(stack) == 0:
            return True
        else:
            return False


    if __name__ == '__main__':
