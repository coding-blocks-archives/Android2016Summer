package com.codingblocks.lecturefiveadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final String TAG = "RecyclerView";

    RecyclerView courseRecyclerView;
    ArrayList<Courses.Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        courseRecyclerView = (RecyclerView) findViewById(R.id.course_list_recyclerview);
        courseList = Courses.getCourses();

        CourseRecyclerViewAdapter courseRecyclerViewAdapter = new CourseRecyclerViewAdapter(courseList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        courseRecyclerView.setLayoutManager(layoutManager);

        courseRecyclerView.setAdapter(courseRecyclerViewAdapter);

        courseRecyclerViewAdapter.notifyDataSetChanged();

    }

    public class CourseRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView courseName;
        public TextView courseStrength;

        public CourseRecyclerViewHolder(View itemView) {
            super(itemView);

            courseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            courseStrength = (TextView) itemView.findViewById(R.id.tv_course_strength_perc);

        }
    }

    public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewHolder> {


        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        private ArrayList<Courses.Course> mCourses;

        public CourseRecyclerViewAdapter(ArrayList<Courses.Course> mCourses) {
            this.mCourses = mCourses;
        }

        @Override
        public CourseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder: called");

            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.list_item_course, null);

            CourseRecyclerViewHolder courseRecyclerViewHolder = new CourseRecyclerViewHolder(itemView);
            return courseRecyclerViewHolder;
        }


        @Override
        public void onBindViewHolder(CourseRecyclerViewHolder holder, int position) {

            Courses.Course thisCourse = mCourses.get(position);

            holder.courseName.setText(thisCourse.name);
            float strength = (((float)thisCourse.enrollment)/((float)thisCourse.capacity)) * 100;
            holder.courseStrength.setText(String.valueOf(strength));

        }

        @Override
        public int getItemCount() {
            return mCourses.size();
        }
    }
}
