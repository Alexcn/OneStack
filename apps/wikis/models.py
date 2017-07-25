from django.db import models
from apps.common.models import BaseModel
from model_utils.fields import StatusField
# from model_utils import Choices


class Category(BaseModel):
    name = models.CharField(max_length=128)


class Wiki(BaseModel):
    title = models.CharField(max_length=254, db_index=True)
    # author_id = models.IntegerField(default=1)
    content = models.TextField(max_length=5000)
    # wiki_type = models.CharField(max_length=256)
    category_id = models.ManyToManyField(Category)

    class Meta:
        db_table = 'wikis'
        ordering = ['-created_at']
