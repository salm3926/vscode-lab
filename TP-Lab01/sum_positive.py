def sum_positive_numbers(numbers):
    if not numbers:  # Handle empty list
        return 0
    
    # Check for negative numbers
    if any(num < 0 for num in numbers):
        raise ValueError("List contains negative numbers")
    
    return sum(numbers)