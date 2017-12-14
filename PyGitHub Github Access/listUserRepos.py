from github import Github 
import getpass
from nvd3 import discreteBarChart
from IPython.core.display import display, HTML
#nvd3.ipynb.initialize_javascript()

#https://github.com/PyGithub/PyGithub

#print user repo's


# using username and password
user = raw_input("Enter username: ")
password = getpass.getpass('Enter password: ')

g = Github(user, password)

# Then play with your Github objects:
for repo in g.get_user().get_repos():
    print repo.name

from nvd3 import pieChart

# Open File to write the D3 Graph
output_file = open('test-nvd3.html', 'w')

chart = discreteBarChart(name='discreteBarChart', height=400, width=400)

xdata = ["A", "B", "C", "D", "E", "F"]
ydata = [3, 4, 0, -3, 5, 7]

chart.add_serie(y=ydata, x=xdata)
chart.buildhtml()
output_file.write(chart.htmlcontent)

# close Html file
output_file.close()
