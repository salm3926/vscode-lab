import pytest
from sum_positive import sum_positive_numbers

def test_sum_positive_numbers():
    # Test normal case
    assert sum_positive_numbers([1, 2, 3]) == 6
    
    # Test empty list
    assert sum_positive_numbers([]) == 0
    
    # Test single number
    assert sum_positive_numbers([5]) == 5
    
    # Test zero
    assert sum_positive_numbers([0]) == 0
    
    # Test with negative numbers
    with pytest.raises(ValueError):
        sum_positive_numbers([1, -2, 3])
    
    # Test with all zeros
    assert sum_positive_numbers([0, 0, 0]) == 0