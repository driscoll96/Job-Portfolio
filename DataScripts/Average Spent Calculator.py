import time
from datetime import datetime, date, time, timedelta
from dateutil.relativedelta import relativedelta

def calc_average(revenue_lst):
    total = 0
    for r in revenue_lst:
        total += r
    return total/len(revenue_lst)

def check_new_customer(customer_name, next_line):
    next_line_lst = list(next_line.split(","))
    if (len(next_line_lst) < 6):
        return False
    if (next_line_lst[2] == (customer_name)):
        return False
    return True
    
def check_order_date(cur_order_date, first_order_date):
    first_date = date(int(first_order_date[6:10]), int(first_order_date[0:2]), int(first_order_date[3:5]))
    first_date = first_date + relativedelta(months=+6)
    new_date = date(int(cur_order_date[6:10]), int(cur_order_date[0:2]), int(cur_order_date[3:5]))
    if (new_date > first_date):
        return False
    return True

def find_new_customer(cur_customer, next_line, open_file):
    flag = False
    next_line_lst = list(next_line.split(","))
    if (len(next_line_lst) < 8):
        return True
    while (flag == False):
        next_line_lst = list(next_line.split(","))
        if (next_line_lst[2] != cur_customer):
            flag = True
        else:
            next_line = open_file.readline()
    return next_line

def get_each_customer():
    read_append_path = "/Users/User/OneDrive/Loopie Stuff/Average Spent by Customer in 6 Months.csv"
    file_read_append = open(read_append_path, "r")
    customer_orders_revenue = []
    customer_revenue = 0
    line = file_read_append.readline()
    # print(line)
    line = file_read_append.readline()
    line_lst = list(line.split(","))
    # print(line)
    # print(1)
    while line:
        # print(2)
        line_lst = list(line.split(","))
        customer_name = line_lst[2]
        # cur_pos = file_read_append.tell()
        line = file_read_append.readline()
        first_order_date = line_lst[1]
        # print(customer_name)
        if (check_new_customer(customer_name, line) == True):
            # print(1)
            customer_revenue += float(line_lst[5][1:])
            customer_orders_revenue.append(customer_revenue)
            customer_revenue = 0
        elif (check_order_date(line_lst[1], first_order_date) == False):
            # print(1)
            customer_orders_revenue.append(customer_revenue)
            customer_revenue = 0
            line = find_new_customer(customer_name, line, file_read_append)
        else:
            customer_revenue += float(line_lst[5][1:])
    average = calc_average(customer_orders_revenue)
    print(average)
    # file_read_append.write(str(average))
    file_read_append.close()


def main():
    file_read = input("Enter the CSV file to format:")
    directory = input("Enter the output directory:")
    get_each_customer()
