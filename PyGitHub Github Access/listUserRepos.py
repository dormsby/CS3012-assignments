from github import Github 
import getpass
from nvd3 import discreteBarChart
from IPython.core.display import display, HTML
#nvd3.ipynb.initialize_javascript(use_remote=True)

#https://github.com/PyGithub/PyGithub

# Open File to write the D3 Graph
output_file = open('test-nvd3.html', 'w')
xdata = []
ydata = []

chart = discreteBarChart(name='discreteBarChart', height=400, width=400)


# using username and password
user = raw_input("Enter username: ")
password = getpass.getpass('Enter password: ')
r = raw_input("Enter repository name: ")

g = Github(user, password)

# Then play with your Github objects:
repo = g.get_user().get_repo(r)
i =0
for con in repo.get_contributors():
	xdata.insert(i,con.login)
	ydata.insert(i,con.contributions)
	i += 1


chart.add_serie(y=ydata, x=xdata)
chart.buildhtml()
output_file.write(chart.htmlcontent)
#display(HTML(chart.htmlcontent))

# close Html file
output_file.close()

print "HTML chart has been output."
