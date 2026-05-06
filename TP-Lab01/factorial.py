def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1)  # Removed the "+ 1" that was causing the bug