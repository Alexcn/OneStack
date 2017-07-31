from django.shortcuts import render
from django.views.generic import ListView, CreateView, UpdateView
from django.utils.decorators import method_decorator
# from django.contrib.auth.decorators import login_required
from apps.common.utils import LoginRequiredMixin


class AssetListView(LoginRequiredMixin, ListView):
    def get(self, request):
        pass


class AssetAddView(LoginRequiredMixin, CreateView):
    def get(self, request):
        pass

    def post(self, request):
        pass


class AssetUpdateView(LoginRequiredMixin, CreateView):
    pass
