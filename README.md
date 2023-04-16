# MovieMobileCA

<b>Student Name: Gbenle Akinola Daniel</b>

<b>Student ID: 24180</b>

<b>Student Email: 24180@student.dorset-college.ie</b>



<h1>Report</h1>

This app is designed to display a list of movies in a recycler view and allow users to select seats for each movie. The app is composed of two main features: the movie recycler view and the seat selection feature.

The movie recycler view is populated with data for each movie, including the movie's title, rating, duration, and description. A random number between 0 and 15 is generated for each movie and assigned to seats_remaining. An initial default value of 0 is set for seats_selected. The app uses random URLs for images from pixabay or other free image providers to display images for each movie.

When a user clicks on a movie item, a new MovieActivity is opened. The MovieActivity displays a plus icon, a minus icon, and the seats_selected value in the middle. When the user clicks the plus or minus icon, the seats_selected and seats_remaining values for that movie are updated. Validation is added to disable the minus icon when 0 seats are selected and disable the plus icon when 0 seats remain. If less than 3 seats remain, a "filling fast" badge is added.

When the user presses the back button, the selected seats are retained and reflected in the recycler view. If there are no updates, the adapter notifyItemChanged is called to update the recycler view.

The app obtains relevant movie data from Vue or other movie providers and displays credits at the bottom of the app.

In terms of design, the app uses the "Roboto Condensed" font to replicate the same style as in the provided images on the moodle. Additionally, the app uses original movie images from myvue.com to enhance the visual appeal.





<b>Problems faced:</b> I faced several problems while making this app, these include: displaying images from internet source, displaying data from second screen to the first screen



<b>How I solved them:</b> I reffered to the videos on my Mobile App moodle and also YouTube and I used Glide Image loader to load the images (movie posters) from myvue.com.


<h2></b>Image Credit: myvue.com</b></h2>
