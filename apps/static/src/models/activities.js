import { queryActivities } from '../services/api';

export default {
  namespace: 'activities',

  state: {
    list: [],
    loading: true,
  },

  effects: {
    *fetchList(_, { call, put }) {
      yield put({
        type: 'changeLoading',
        payload: true,
      });
      const response = yield call(queryActivities);
      yield put({
        type: 'saveList',
        payload: Array.isArray(response) ? response : [],
      });
      yield put({
        type: 'changeLoading',
        payload: false,
      });
    },
  },

  reducers: {
    saveList(state, action) {
      return {
        ...state,
        list: action.payload,
      };
    },
    changeLoading(state, action) {
      return {
        ...state,
        loading: action.payload,
      };
    },
  },
};
