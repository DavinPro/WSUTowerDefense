package com.wsu.towerdefense.model.highscores;

import java.sql.ResultSet;

public interface DBListener {

    void release();

    interface OnTaskEnded {

        /**
         * This method is called once the AsyncTask has completed
         */
        void onTaskEnd(ResultSet rs);
    }
}
