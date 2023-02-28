from flask import Flask, render_template, redirect, url_for, request, Markup
import sqlite3

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def login():
	error = None
	query = ""
	if request.method == 'POST':
		if request.form['username'] != "" and request.form['password']:
			user_name = request.form['username']
			conn = sqlite3.connect('sample.db')
			curs = conn.cursor()
			query = "SELECT employees.Email FROM employees WHERE employees.Email = '%s'" % (user_name)
			curs.execute(query)

			query_result = curs.fetchone()
			if query_result is not None:
				return redirect(url_for('search'))
			error = 'Invalid Credentials. Please try again.'
	return render_template('login.html', error=error, query=query)

@app.route('/search', methods=['GET', 'POST'])
def search():
	error = None
	output = ""
	query = ""
	if request.method == 'POST':
		if request.form['artist'] != "":
			artist_name = request.form['artist']
			conn = sqlite3.connect('sample.db')
			curs = conn.cursor()
			query = "SELECT albums.Title FROM albums inner join artists WHERE albums.ArtistId = artists.ArtistId and artists.Name = '%s'" % (artist_name)

			# SQLite3 .execute doesn't allow execution of multiple SQL queries at once, so this workaround is just to make the demo possible.
			individual_queries = query.split(';')
			for q in individual_queries:
				curs.execute(q)
				q_result = curs.fetchall()
				for entry in q_result:
					for el in entry:
						output += str(el) + ", "
					output += '<br>'
		else:
			return redirect(url_for('search'))
	output = Markup(output)
	return render_template('search.html', error=error, output=output, query=query)

if __name__ == '__main__':
	app.run(debug=True)